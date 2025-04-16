package me.fit.sheduler;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;
import me.fit.model.client.TimeResponse;
import me.fit.restclient.TimeClient;

public class SchedulerUtil {

	@RestClient
	TimeClient timeClient;
	
	@Scheduled(every="1s")     
    void getTime() {
        TimeResponse time = timeClient.getTime("Europe/Amsterdam");
        System.out.println(time);
    }
    
}
