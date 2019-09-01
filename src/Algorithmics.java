import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class contains different algorithms
 */
class Algorithmics {

    /**
     * @param numberDec - number in decimal format
     * @return - maximum numbers of "0" surrounded by "1" in binary representation of @param
     */
    int calculateMaxGap(int numberDec) {
        List<Integer> binArray = convertDecToBin(numberDec);
        if (binArray.size() < 3) {
            return 0;
        } else {
            int maxGap = 0;
            for (int i = 1; i < binArray.size() - 1; i++) {
                if (binArray.get(i - 1) == 1 && binArray.get(i) == 0) {
                    int j = 0;
                    while (i < binArray.size() && binArray.get(i) == 0) {
                        j++;
                        i++;
                    }
                    if (i < binArray.size() && binArray.get(i) == 1) {
                        if (j > maxGap) {
                            maxGap = j;
                        }
                    }
                    i--;
                }
            }
            return maxGap;
        }
    }

    /**
     *
     * @param numberDec - number in decimal format
     * @return - binary representation of @param
     */
    private List<Integer> convertDecToBin(int numberDec) {
        List<Integer> binaryRepresentation = new ArrayList<>();
        while (numberDec > 0) {
            binaryRepresentation.add(numberDec % 2);
            numberDec = numberDec / 2;
        }
        Collections.reverse(binaryRepresentation);
        System.out.println(binaryRepresentation);
        return binaryRepresentation;
    }
}