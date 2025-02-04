package com.innovativeSurveyor.usermanagement.service;

import com.twilio.type.PhoneNumber;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.Twilio;

public class OTPService {
	
	private final Map<String, String> otpStore = new ConcurrentHashMap<>();
    private final Map<String, Long> otpExpiryStore = new ConcurrentHashMap<>();
    private final MessagingTemplate messagingTemplate;
  //  private final MessageChannel messagingChannel;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final long OTP_EXPIRY_DURATION = 5; // OTP expiry duration in minutes

    @Autowired
    public OTPService(MessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendOtp(String username) {
        String otp = generateOtp();
        otpStore.put(username, otp);
        otpExpiryStore.put(username, System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(OTP_EXPIRY_DURATION));
      //  messagingTemplate.send("otpChannel",MessageBuilder.withPayload("OTP for "+username+" :"+otp).build());
        scheduleOtpExpiry(username);
        System.out.println(otp);
    }

    public boolean validateOtp(String username, String otp) {
        Long expiryTime = otpExpiryStore.get(username);
        if (expiryTime == null || System.currentTimeMillis() > expiryTime) {
            otpStore.remove(username);
            otpExpiryStore.remove(username);
            return false;
        }
        return otp.equals(otpStore.get(username));
    }
    
    public void invalidateOtp(String userId) {
    	otpStore.remove(userId);
    }

    private void scheduleOtpExpiry(String username) {
        scheduler.schedule(() -> {
            otpStore.remove(username);
            otpExpiryStore.remove(username);
        }, OTP_EXPIRY_DURATION, TimeUnit.MINUTES);
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
	}

@MessagingGateway
interface OtpGateway {
    void sendOtpMessage(String message);
}

class MessagingConfig {

	private static final String ACCOUNT_SID = "";
	private static final String AUTH_TOKEN=""; 
	private static final String FROM_PHONE_NUMBER = "";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}
	
    @Bean
    public MessageChannel otpChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "otpChannel")
    public MessageHandler otpMessageHandler() {
    	return message->{
    		System.out.println("OTP is : "+message.getPayload());
    	};
//        return message -> {
//          String payload = (String)	message.getPayload();
//          String [] parts = payload.split(":");
//          String username = parts[0].split(" ")[2];
//          String otp = parts[1].trim();
//          String toPhoneNumber = getUserPhoneNUmber(username);
//          
//          Message.creator(
//        		  new PhoneNumber(toPhoneNumber),
//        		  new PhoneNumber(FROM_PHONE_NUMBER),
//        		  "Your OTP is: "+otp
//        		  ).create();
//          
//        };
        
        
    }

	private String getUserPhoneNUmber(String username) {
		return "+918109744303";
	}
}
