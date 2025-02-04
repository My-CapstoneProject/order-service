// package com.sr.order_service.service;

// import io.keen.client.java.KeenClient;
// import io.keen.client.java.KeenProject;
// import io.keen.client.java.exceptions.KeenException;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import java.util.Map;

// @Service
// public class KeenService {

//     private final KeenClient keenClient;

//     public KeenService(
//         @Value("${keen.project.id}") String projectId,
//         @Value("${keen.write.key}") String writeKey
//     ) {
//         KeenProject project = new KeenProject(projectId, writeKey, null);
    
//         this.keenClient = KeenClient.client();    
//         this.keenClient.setDefaultProject(project);
//         this.keenClient.setDebugMode(true);
//     }

//     public void logEvent(String collection, Map<String, Object> eventData) {
//         try {
//             keenClient.addEvent(collection, eventData);
//         } catch (KeenException e) {
//             e.printStackTrace();
//         }
//     }
// }