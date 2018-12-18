package com.example.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Iterator;
import java.util.List;
@XStreamAlias("allprograms")
public class Programs {
    private List<Program> programs;

    public Programs(List<Program> programs) {
        this.programs = programs;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "programs=" + programs +
                '}';
    }
}
