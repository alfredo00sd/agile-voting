package org.dominisoft.scrumdev.claro2020.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CandidateLoader {
  String filePath;

  /**
   * This method creates a candidate loader.
   * 
   * @param filePath filePath
   */
  public CandidateLoader(String filePath) {

    if (filePath == null) {
      throw new NullPointerException();
    }
    this.filePath = filePath;

  }

  public List<Candidate> getCandidates() {
    return readCandidates();
  }

  private List<Candidate> readCandidates() {
    List<Candidate> candidates = new ArrayList<>();

    try {

      File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(this.filePath)).getFile());
      InputStream inputFS = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
      String line = br.readLine();

      while (line != null) {
        String[] attributes = line.split(",");
        Candidate candidate = Candidate.instance(attributes);
        candidates.add(candidate);
        line = br.readLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return candidates;
  }

}
