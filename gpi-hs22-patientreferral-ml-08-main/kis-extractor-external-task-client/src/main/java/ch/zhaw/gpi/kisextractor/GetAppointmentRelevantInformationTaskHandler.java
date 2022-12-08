package ch.zhaw.gpi.kisextractor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ExternalTaskSubscription("GetAppointmentRelevantInformation")
public class GetAppointmentRelevantInformationTaskHandler implements ExternalTaskHandler {

    @Autowired
    private RestTemplate kisRestClient;
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        
        Long caseId = (Long) externalTask.getVariable("case_id");
        Date dateEarliest = null;
        Date dateLatest = null;

        try {
                ResponseEntity<MedicalCaseRepresentation> medicalCaseResponse = kisRestClient.exchange(
                    "http://localhost:8090/api/medicalCases/{caseId}", HttpMethod.GET, null,
                    MedicalCaseRepresentation.class, caseId);
                MedicalCaseRepresentation medicalCase = medicalCaseResponse.getBody();
            
                dateEarliest = medicalCase.getDate_earliest();
                dateLatest = medicalCase.getDate_latest();

            //externalTask.setVariable("case_appointment_earliest", kisResponse.getBody().getDateEarliest());
            //externalTask.setVariable("case_appointment_latest", kisResponse.getBody().getDateLatest());

            Map<String, Object> varMap = new HashMap<>();

            varMap.put("case_appointment_earliest", dateEarliest);
            varMap.put("case_appointment_latest", dateLatest);

            externalTaskService.complete(externalTask, varMap);

        } catch (Exception e) {
            externalTaskService.handleFailure(externalTask, "Fall-ID nicht vorhanden!", null, 0, 0);
        }
        
    }
    
}
