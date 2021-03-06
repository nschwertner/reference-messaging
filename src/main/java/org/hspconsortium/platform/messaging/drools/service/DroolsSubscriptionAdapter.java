package org.hspconsortium.platform.messaging.drools.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.IResource;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hspconsortium.platform.messaging.service.SubscriptionManagerService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class DroolsSubscriptionAdapter {

    @Inject
    SubscriptionManagerService subscriptionManagerService;

    public void submitResource(String resourceJson) {
        IBaseResource resource = FhirContext.forDstu2().newJsonParser().parseResource(resourceJson);
        subscriptionManagerService.submitResource((IResource)resource);
    }
}
