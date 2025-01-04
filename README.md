 <h1>Play cipher encryption</h1>
        <h4>One of the most popular encryption models in the world, was the first cipher to encrypt pairs of letters in cryptologic history. <br> 
            <br> <q>Wheatstone</q> invented the cipher for secrecy in telegraphy, but it carries the name of his friend <q>Lord Playfair</q>. </h4>
         <p>   <img src="440px-Wheatstone_Charles_drawing_1868.jpg" alt="Wheatstone" width="200" >  <img src="Lyon_Playfair.jpg" alt="Lyon_Playfair" width="200" > </p>
            <p style="margin-right:100px;">     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">Wheatstone</span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;"> Lord Playfair </span> </p>
        </div>
        <br>
    </div>
        <h2>What is the encryption method?</h2>
        <h4>The playfair cipher requires 5*5 matrix consists with english alphabetic which equle 25 letters, but we missing out one char!!, the char that we throw out is "J", we don't need it in this encryption.</h4>
       <h2>For example:</h2>
       <h3>Let's assume that the wordkey is "mouseye" the matrix will be like this:</h3>
       <img src="Screenshot 2025-01-04 071927.png" alt="matrix 5*5 " width="300px" >
       <h3>The first thing we notice that is the letters of the key word are written at beginning, and "e" char has not been rewritten. <br>
       that because we need from the key word only "chars" not whole "keyword".</h3>
       <h3> Assume that the plaintxet is "cold", here is how to encrypted</h3>
       <h2>stpe 1 'c' and 'o':</h2>
       <img src="Screenshot 2025-01-04 082401.png" alt="encryption c and o" width="300">
       <h3>When we find the tow letters, we put square around them, and after this we chose the most left letter (for c) and the most right letter (for o) to be "AS" </h3>
       <h2>Step 2 'l' and 'd' :</h2>
       <img src="Screenshot 2025-01-04 083605.png" alt="step 2" width="300px">
       <h3>Doing the same thing to get the cipher text: "ASRY" </h3>
       <br> <br>
       <h1>Code interpretation </h1>
       
        String preparedText = preparePlaintext(plaintext);
        String encryptedText = encrypt(preparedText, matrix);

        System.out.println("\nEncrypted Text: " + encryptedText);
    }
<h3>Using preparePlaintext and encrypt methods  </h3>



   



   

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

<h5>Welcome design</h5>

` System.out.print("Enter Keyword: ");
        String keyword = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
       char[][] matrix = createMatrix(keyword); 
       printmatrix(matrix);
         System.out.print("Enter Text to Encrypt: ");
        String plaintext = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        if (keyword.isEmpty() || plaintext.isEmpty()) {
            System.out.println("Please provide both a keyword and plaintext.");
            return;
        }`


<h5>The program ask user to write the keyword, the </h5>  

`scanner.nextLine()`<p>To make the user able to put input. </p> 


`.toUpperCase()`<p> To make all alphabets capitales </p>


`replaceAll("[^A-Z]", "").replace('J', 'I');` <p> To replace all input dose't letters to nothing, and replace any input hava 'j' char to 'i' because we don't want 'j' letter. </p>

` if (keyword.isEmpty() || plaintext.isEmpty()) {
            System.out.println("Please provide both a keyword and plaintext.");
            return;
        }`

<p>If the keyword or the plaintext are empty print "Please provide both a keyword and plaintext." </p>




`
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
    }`
    <br>
  `  String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
        char[][] matrix = new char[5][5];
        boolean[] used = new boolean[26];
`
   <h3> create the alphabets with out j, create char vairable with 2D array, and boolean to check if char has been used or not. </h3>

 




        


