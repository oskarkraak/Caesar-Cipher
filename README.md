# CaesarCipher
A variation of the well-known Caesar cipher.

# How it works
The program will count the number of letters (only those of the English alphabet) in each word. It then rotates every single word by the number of letters the word has.

This has the advantage that a frequency analysis (determining the frequecy of each letter in the text to break the cipher) becomes less effective since a "B" in a 5-letter-word is not substituted with the same letter as a "B" in a 4-letter-word.
However, this variation removes the aspect of the key (number of places that each letter was rotated) that was used in the traditional Casear cipher. In modern cryptology, keys are preferred since it is more secure to keep the key secret than the cipher.
All in all, this method is more for fun than for actual security. Modern computers will break the cipher in no time. It provides some protection against humans, as long as they do not figure out how to decrypt the text.

# API
Use the Coder class to encrypt/decrypt Strings by calling the encrypt(String text) or decrypt(String text) method.
You can also use the traditional Caesar cipher by calling the rotate(String text, int key) method. Thus, ROT13 can be used calling rotate(String text, 13).
