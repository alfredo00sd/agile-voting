package org.dominisoft.scrumdev.claro2020.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CandidateLoader {
  String filePath;
  private List<Candidate> candidates;


  /**
   * This method creates a candidate loader.
   * 
   * @param filePath filePath
   */
  public CandidateLoader(String filePath) {

    if (filePath == null) {
      throw new NullPointerException();
    }
    this.candidates = new ArrayList<>();
    this.filePath = filePath;
    readCandidates();
  }

  public int getSize() {
    return this.candidates.size();
  }

  public void trick() {
    this.candidates.clear();
  }

  public void backTrick() {
    readCandidates();
  }

  public List<Candidate> getCandidates() {
    return this.candidates;
  }

  private void readCandidates() {
    try {

      File file = new File("target/test-classes/" + this.filePath);
      System.out.println(file.getAbsolutePath());
      InputStream inputFS = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
      String line = br.readLine();

      while (line != null) {
        String[] attributes = line.split(",");
        Candidate candidate = Candidate.instance(attributes);
        this.candidates.add(candidate);
        line = br.readLine();
      }

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }

}
