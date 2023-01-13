package com.poc.commun;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface JobSocleOptions extends PipelineOptions {

    @Description("param example")
    @Default.String("name")
    String getName();
    void setName(String value);

}
