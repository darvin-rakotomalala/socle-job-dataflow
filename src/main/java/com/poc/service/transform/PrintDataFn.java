package com.poc.service.transform;

import com.poc.commun.JobSocleOptions;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PrintDataFn extends DoFn<String, String> {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(PrintDataFn.class);

    @ProcessElement
    public void processElement(ProcessContext c) {

        try {

            JobSocleOptions ops = c.getPipelineOptions().as(JobSocleOptions.class);
            // LOG.info(ops.getName().get());
            LOG.info(ops.getName());

            LOG.info("---- Element : {}", c.element());

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Error : " + e.getMessage());
        }
    }
}
