package blackjack.game;

import java.util.Scanner;

/**
 *
 * @author erdmcagri
 */
public class BlackjackGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double playerMoney = 100.0;

        Scanner scan = new Scanner(System.in);

        while (playerMoney > 0) {
            Deck deckMain = new Deck();
            deckMain.createDeck();
            deckMain.shuffle();
            
            System.out.println("-----------------------------Yeni El----------------------------------");
            Deck oyuncuKart = new Deck();
            Deck kasaKart = new Deck();

            System.out.println(playerMoney + " TL paranız var. Bahse girmek istediğiniz miktarı giriniz: ");
            double bahisMiktari = scan.nextDouble();
            boolean isGameEnd = false;

            if (bahisMiktari > playerMoney) {
                System.out.println("Elinizdeki para kadar bahis oynayabilirsiniz!");
            } else {
                oyuncuKart.draw(deckMain);
                oyuncuKart.draw(deckMain);

                kasaKart.draw(deckMain);
                kasaKart.draw(deckMain);

                while (true) {
                    System.out.println("Elinizdeki Kartlar:");
                    oyuncuKart.showCards();
                    System.out.println("Elinizdeki kartların değeri: " + oyuncuKart.cardValues());

                    System.out.println("Kasadaki kartlar: " + kasaKart.getCard(0).cardType + " " + kasaKart.getCard(0).cardValue + " ve bir kapalı kart.");

                    System.out.println("Kart çekmek için 1 e, kalmak için 2 ye basın");
                    int response = scan.nextInt();
                    if (response == 1) {
                        oyuncuKart.draw(deckMain);
                        System.out.println("Çektiğiniz kart : " + oyuncuKart.getCard(oyuncuKart.deckSize() - 1));

                        if (oyuncuKart.cardValues() > 21) {
                            System.out.println("Kaybettiniz. Elinizdeki kartların değeri : " + oyuncuKart.cardValues());
                            playerMoney -= bahisMiktari;
                            isGameEnd = true;
                            break;
                        }
                    }

                    if (response == 2) {
                        break;
                    }

                }

                System.out.println("Kasadaki kartlar: ");
                kasaKart.showCards();

                if ((kasaKart.cardValues() > oyuncuKart.cardValues()) && isGameEnd == false) {
                    System.out.println("Kasa kazandı. Kasanın kart değeri: " + kasaKart.cardValues() + " Oyuncu kart değeri: " + oyuncuKart.cardValues());
                    playerMoney -= bahisMiktari;
                    isGameEnd = true;

                }

                while ((kasaKart.cardValues() < 17) && isGameEnd == false) {
                    kasaKart.draw(deckMain);
                    Card tmp = kasaKart.getCard(kasaKart.deckSize() - 1);
                    System.out.println("Kasanın çektiği kart : " + tmp.cardType + " " + tmp.cardValue);

                }

                System.out.println("Kasanın elindeki kartların değeri: " + kasaKart.cardValues());

                if ((kasaKart.cardValues() > 21) && isGameEnd == false) {
                    System.out.println("Tebrikler kazandınız.");
                    playerMoney += bahisMiktari * 1.5;
                    isGameEnd = true;
                }

                if ((kasaKart.cardValues() == oyuncuKart.cardValues()) && isGameEnd == false) {
                    System.out.println("Bu elin kazananı yok.");
                    isGameEnd = true;
                }

                if ((oyuncuKart.cardValues() > kasaKart.cardValues()) && isGameEnd == false) {
                    System.out.println("Eli kazandınız.");
                    playerMoney += bahisMiktari * 1.5;
                    isGameEnd = true;
                } else if (isGameEnd == false) {
                    System.out.println("Kasa kazandı");
                    playerMoney -= bahisMiktari;
                }
            }
        }

        System.out.println("Hiç paranız kalmadı.");

        scan.close();

    }

}
