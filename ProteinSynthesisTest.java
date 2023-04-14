import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    @Test
    void transcribeDNA() {
        ProteinSynthesis testing = new ProteinSynthesis();
        CharQueue result = testing.transcribeDNA("TATGCG");
        assertEquals('G', result.peek());
    }

    @Test
    void translateRNA() {
        ProteinSynthesis testing = new ProteinSynthesis();
        CharQueue rna = testing.transcribeDNA("ATGCTATG");
        CharQueue result = testing.translateRNA(rna);
        assertEquals("MLC", result.peek());
    }

}