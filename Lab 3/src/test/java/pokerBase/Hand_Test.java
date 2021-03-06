package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void FiveOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		
	}
	
	@Test
	// Five of a Kind Test with a Joker
	public void JFiveOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		
	}

	@Test
	// Test Natural Royal Flush (no Jokers)
	public void NaturalRoyalFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.NaturalRoyalFlush.getHandStrength());
		
	}
	
	@Test
	// Test Royal Flush with Jokers
	public void RoyalFlush() throws exHand{
		// A deck with 3 jokers and a King and Ace of clubs should evaluate to a Royal Flush
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		assertTrue(h.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		
	}

	
	@Test
	public void StraightFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);	
	}
	
	@Test
	// Straight Flush with Joker
	public void JStraightFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);	
	}
	
	@Test
	public void Flush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	// Test Flush with a Joker
	public void JFlush() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void Straight() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	//Test a Straight with a Joker
	public void JStraight() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.JACK,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.KING.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker() == null);
	}
	
	@Test
	public void FourOfAKind_1() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		
		//	Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());
		
	}		

	@Test
	public void FourOfAKind_2() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
	}		

	@Test
	//Test a Four of a Kind with a Joker
	public void JFourOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		
		//	Check to see if the kicker is a NINE
		assertTrue(c1.getRank().getRank() == eRank.NINE.getRank());
		
	}
	
	@Test
	public void ThreeOfAKind_1() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}		
	@Test
	public void ThreeOfAKind_2() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		
		//	Check to see if the first kicker is a KING
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());
		
		//	Check to see if the second kicker is a NINE
		assertTrue(c2.getRank().getRank() == eRank.NINE.getRank());
	}		
	@Test
	public void ThreeOfAKind_3() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.THREE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		
		//	Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.THREE.getRank());
		
		//	Check to see if the second kicker is a TWO
		assertTrue(c2.getRank().getRank() == eRank.TWO.getRank());		
	}
	
	@Test
	// Test a three of a kind with a Joker
	public void JThreeOfAKind() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 2);
	}	
	@Test
	public void FullHouse_1() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker() == null);	
	}		
	@Test
	public void FullHouse_2() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getKicker() == null);	
	}	
	
	@Test
	// Test Full House with a Joker - will always be the high card
	public void JFullHouse() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker() == null);	
	}	
	
	//Note: A hand with a Joker will NEVER evaluate to a two pair (logic)
	@Test
	public void TwoPair() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.TwoPair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == eRank.TWO.getRank());
		assertTrue(h.getKicker().size() == 1);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		
		//	Check to see if the first kicker is a THREE
		assertTrue(c1.getRank().getRank() == eRank.ACE.getRank());
	}
	
	
	@Test
	public void Pair() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		
		//	Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.ACE.getRank());

		//	Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());

		//	Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());

	}
	
	@Test
	// Test a pair with a Joker - will always match highest card in hand
	public void JPair() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 3);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		
		//	Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.TEN.getRank());

		//	Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.THREE.getRank());

		//	Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.TWO.getRank());

	}
	
	//Note: Hand with Joker will NEVER evaluate to HighCard
	@Test
	public void HighCard() throws exHand{
		Deck d = new Deck();
		Hand h = new Hand();
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		h.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h.EvalHand();
		
		assertTrue(h.getHandStrength() == eHandStrength.HighCard.getHandStrength());
		assertTrue(h.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h.getLowPairStrength() == 0);
		assertTrue(h.getKicker().size() == 4);
		
		Card c1 = h.getKicker().get(eCardNo.FirstCard.getCardNo());
		Card c2 = h.getKicker().get(eCardNo.SecondCard.getCardNo());
		Card c3 = h.getKicker().get(eCardNo.ThirdCard.getCardNo());
		Card c4 = h.getKicker().get(eCardNo.FourthCard.getCardNo());
		
		//	Check value of kicker
		assertTrue(c1.getRank().getRank() == eRank.KING.getRank());

		//	Check value of kicker
		assertTrue(c2.getRank().getRank() == eRank.TEN.getRank());

		//	Check value of kicker
		assertTrue(c3.getRank().getRank() == eRank.THREE.getRank());

		//	Check value of kicker
		assertTrue(c4.getRank().getRank() == eRank.TWO.getRank());

	}		
	
	@Test
	public void CompareTwoHands() throws exHand{
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h1.EvalHand();
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h2.EvalHand();	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		
		winningHand = TwoHands.get(0);
		
		assertTrue(winningHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.NINE.getRank());
		
	}	
	
	@Test
	// Test to compare two hands, each with Jokers in them
	public void JCompareTwoHands() throws exHand{
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h1.EvalHand();
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h2.EvalHand();	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		
		Hand winningHand = h1.PickBestHand(TwoHands);

		assertTrue(winningHand.getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.NINE.getRank());
		
	}	
}













