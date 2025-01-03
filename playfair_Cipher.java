import java.util.Scanner;

public class playfair_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("W       W      EEEEE      L           CCCCC      OOOOO      M     M      EEEEE");
        System.out.println("W       W      E          L          C          O     O     MM   MM      E    ");
        System.out.println("W   W   W      EEEE       L          C          O     O     M M M M      EEEE ");
        System.out.println(" W W W W       E          L          C          O     O     M  M  M      E    ");
        System.out.println("  W   W        EEEEE      LLLLL      CCCCC       OOOOO      M     M      EEEEE");
        System.out.println();
        System.out.println("**************************************************************************************************************");
        System.out.println("|______________________________________________________________________________________________________________|");
       

    

        System.out.println("Playfair Cipher Encryption");
        System.out.print("Enter Keyword: ");
        String keyword = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
       char[][] matrix = createMatrix(keyword); 
       printmatrix(matrix);

        System.out.print("Enter Text to Encrypt: ");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');

        if (keyword.isEmpty() || plaintext.isEmpty()) {
            System.out.println("Please provide both a keyword and plaintext.");
            return;
        }

        
        String preparedText = preparePlaintext(plaintext);
        String encryptedText = encrypt(preparedText, matrix);

        System.out.println("\nEncrypted Text: " + encryptedText);
    }

    public static char[][] createMatrix(String keyword) {
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
        char[][] matrix = new char[5][5];
        boolean[] used = new boolean[26];
        int index = 0;

        for (char c : keyword.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[index / 5][index % 5] = c;
                used[c - 'A'] = true;
                index++;
            }
        }

        for (char c : alphabet.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[index / 5][index % 5] = c;
                used[c - 'A'] = true;
                index++;
            }
        }

        return matrix;
    }

    public static void printmatrix(char  matrix [][] ){
        System.out.println("\n");
        System.out.println("****************************************");
        System.out.println("\n");

        System.out.println("5x5 PLAYFAIR CIPHER MATRIX!!!!!!:");
    for (int i = 0; i<5; i++){
    System.out.println(" ");
    if(i==0){
        System.out.println("___________________");
     
    }
    
   for(int j=0; j<5; j++){
    System.out.print(matrix[i][j]+ " | ");
    
   }
   if(i==4 && i==4){
    System.out.println();
        System.out.println("___________________");
    }

    
}
  }


    public static String preparePlaintext(String plaintext) {
        StringBuilder prepared = new StringBuilder();
        
        for (int i = 0; i < plaintext.length(); i++) {

            char current = plaintext.charAt(i);

            prepared.append(current);


            if (i + 1 < plaintext.length() && current == plaintext.charAt(i + 1)) {
                prepared.append('X');
            }
        }

       
        if (prepared.length() % 2 != 0) {

            prepared.append('X');
        }

        return prepared.toString();
    }

    public static String encrypt(String plaintext, char[][] matrix) {

        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2)
         {

            char first = plaintext.charAt(i );
            char second = plaintext.charAt(  i + 1);

            int[] pos1 = findPosition(first, matrix  );

            int[] pos2 = findPosition(second, matrix  );

            if (pos1[0] == pos2[0]) { 
                  ciphertext.append(matrix[pos1[0]][(pos1[1] + 1) % 5]);

                 ciphertext.append(matrix[pos2[0]][(pos2[1] + 1) % 5]);

              } else if (pos1[1] == pos2[1]) { 

                   ciphertext.append(matrix[(pos1[0] + 1) % 5][pos1[1]]) ;

                ciphertext.append(matrix[(pos2[0] + 1) % 5][pos2[1]]);

            } else {
                ciphertext.append(matrix[pos1[0]][pos2[1]]);

                ciphertext.append(matrix[pos2[0]][pos1[1]]);
            }
        }

        return ciphertext.toString();
    }

    public static int[] findPosition(char c, char[][] matrix) {

        for (int i = 0; i < 5; i++) {
            
            for (int j = 0; j < 5; j++) {

                if (matrix[i][j] == c) {

                    return new int[]{i, j};
                }
            }
        }
        return null; 
    }
}