package com.j2core.sts.leetcode.com.tmp.mockInterview;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1 {

    private String start_codon = "AUG";
    private String stop_codon = "STOP";
    private Map<String, String> codon_to_amino_acid = new HashMap<String, String>() {{
        put("AUG", "Met");
        put("CAA", "Gln");
        put("CAG", "Gln");
        put("GGU", "Gly");
        put("GCG", "Ala");
        put("UUU", "Phe");
        put("UUC", "Phe");
        put("UGG", "Trp");
        put("UAA", stop_codon);
        put("UAG", stop_codon);
        put("UGA", stop_codon);
    }};

    /*
     * Complete the functions below.
     */

    public String protein_synthesis_part_one(String dna) {
        // Write your code here
        StringBuilder builder = new StringBuilder();
        boolean start = false;
        boolean end = false;
        int counter = 0;
        StringBuilder mRNA = new StringBuilder();
        for (char symbol : dna.toCharArray()){
            if (symbol == 'T'){
                mRNA.append('U');
            }else {
                mRNA.append(symbol);
            }
            counter++;
            if(counter == 3) {
                if (mRNA.toString().equals(start_codon)) {
                    start = true;
                    builder.append(codon_to_amino_acid.get(mRNA.toString()));
                    mRNA = new StringBuilder();
                    counter = 0;
                    continue;
                }
                String amino = codon_to_amino_acid.get(mRNA.toString());
                if (amino.equals(stop_codon)) {
                    end = true;
                    break;
                } else if (start) {
                    builder.append(amino);
                }
                counter = 0;
                mRNA = new StringBuilder();
            }
        }
        if (builder.length() == 0 || !end) return "INVALID";
        return builder.toString();
    }



    @Test
    public void test(){

        Assert.assertEquals("Met Gln Ala", protein_synthesis_part_one("CAAATGCAGGCGTAA"));
    }

    public String protein_synthesis_part_two(String dna) {
        // Write your code here

        StringBuilder builder = new StringBuilder();
        boolean start = false;
        boolean end = false;
        int counter = 0;
        StringBuilder mRNA = new StringBuilder();
        for (char symbol : dna.toCharArray()){
            if(!Character.isLowerCase(symbol)){
                if (symbol == 'T'){
                    mRNA.append('U');
                }else {
                    mRNA.append(symbol);
                }
                counter++;
                if(counter == 3) {
                    String amino = codon_to_amino_acid.get(mRNA.toString());
                    if (amino != null) {
                        if (amino.equals(stop_codon)){
                            break;
                        }
                        builder.append(amino);
                    }
                    counter = 0;
                    mRNA = new StringBuilder();
                }
            }

        };
        return builder.toString();
    }

    @Test
    public void test2(){

        Assert.assertEquals("MetGlnAla", protein_synthesis_part_two("uagATGcagCAGuaaGCGugaTAA"));
    }
}
