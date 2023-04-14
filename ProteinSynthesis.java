/*
    Name: Christian Guerra
    PID:  A17660168
 */

/**
 *
 *
 * @author Chguerra
 * @since April 13th, 2023
 */
class ProteinSynthesis {
    CharQueue rnaSample = new CharQueue();
    public CharQueue transcribeDNA(String dna) {
        for(int i = 0; i < dna.length(); i++){
            if (dna.charAt(i) == 'T'){
                rnaSample.enqueue('U');
            }
            else{
                rnaSample.enqueue(dna.charAt(i));
            }
        }
        if (dna.length() % 3 != 0){
            throw new IllegalArgumentException();
        }
        return rnaSample;
    }

    public CharQueue translateRNA(CharQueue rna) {
        CharQueue protein = new CharQueue();
        String startCodon = "AUG";
        String codon = "";
        String results = "";

        while (!rna.isEmpty()) {
            char nucleotide = rna.dequeue();
            codon += nucleotide;

            if (codon.length() == 3) {
                if (codon.equals(startCodon)) {
                    char aminoAcid = CodonMap.getAminoAcid(codon);
                    if (aminoAcid == '*') {
                        break; // stop codon if any prohibited comb is found
                    }
                    results += aminoAcid;
                    codon = "";
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
        for (char aminoAcid : results.toCharArray()) {
            protein.enqueue(aminoAcid);
        }

        return protein;
    }

}

