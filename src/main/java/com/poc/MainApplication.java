package com.poc;

import com.poc.commun.JobSocleOptions;
import com.poc.service.transform.PrintDataFn;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MainApplication.class);

    public static <T> void main(String[] args) throws UnsupportedEncodingException {

        ApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);

        PrintDataFn printDataFn = applicationContext.getBean(PrintDataFn.class);

        JobSocleOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(JobSocleOptions.class);
        Pipeline pipe = Pipeline.create(options);

        final List<String> LINES = Arrays.asList(
                "To be, or not to be: that is the question: ",
                "Whether 'tis nobler in the mind to suffer ",
                "The slings and arrows of outrageous fortune, ",
                "Or to take arms against a sea of troubles, ");

        PCollection<String> lines = pipe.apply(Create.of(LINES)).setCoder(StringUtf8Coder.of());

        lines.apply("ReadLinesString", ParDo.of(printDataFn));
        pipe.run();

        LOG.info("############  SHUTTING DOWN #############");
        int exitCode = SpringApplication.exit(applicationContext, () -> 0);
        System.exit(exitCode);
    }

}
