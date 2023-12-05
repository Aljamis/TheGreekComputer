package org.avr.dialpuzzle;

public class DialPuzzle {
	
	private int[][] dialOne = { { 8 , 0 , 3 , 0 , 6 , 0 , 10 , 0 , 7 , 0 , 15 , 0 } };
	private int[][] dialTwo = { { 17 , 7 , 3 , 0 , 6 , 0 , 11 , 11 , 6 , 11 , 0 , 6 }
							, { 0 , 4 , 0 , 7 , 15 , 0 , 0 , 14 , 0 , 9 , 0 , 12 } };
	private int[][] dialThree = { { 17 , 4 , 5 , 0 , 7 , 8 , 9 , 13 ,9 , 7 , 13 , 21 }
							, { 11 , 26 , 14 , 1 , 12 , 0 , 21 , 6 , 15 , 4 , 9 , 18 } 
							, { 22 , 0 , 16 , 0 , 9 , 0 , 5 , 0 , 10 , 0 , 8 , 0 } };
	private int[][] dialFour = { { 7 , 0 , 9 , 0 , 7 , 14 , 11 , 0 , 8 , 0 , 16 , 0 }
							, { 9 , 20 , 12 , 3 , 6 , 0 , 14 , 12 , 3 , 8 , 9 , 0 }
							, { 3 , 26 , 6 , 0 , 2 , 13 , 9 , 0 , 17 , 19 , 3 , 12 }
							, { 1 , 0 , 9 , 0 , 12 , 0 , 6 , 0 , 10 , 0 , 10 , 0 } };
	private int[][] dialFive = { { 14 , 11 , 14 , 11 , 14  , 11 , 11 , 14 , 11 , 14 , 11 , 14 }
							, { 11 , 12 , 13 , 14 , 15 , 4 , 5 , 6 , 7 , 8 , 9 , 10 }
							, { 14 , 21 , 21 , 9 , 9 , 4 , 4 , 6 , 6 , 3 , 3 , 14 }
							, { 7 , 16 , 8 , 7 , 8 , 8 , 3 , 4 , 12 , 2 , 5 , 10 } };
	
	
	public int dial1, dial2 , dial3 , dial4 , dial5;
	public int BIG_SHIFT = 0;


	public static void main(String[] args) {
		
		DialPuzzle me = new DialPuzzle();
		me.beginHere();
	}
	
	
	public void beginHere() {		
			
		int ring1Val, ring2Val, ring3Val, ring4Val = 0;
		
		for ( dial1=0 ; dialOne[0].length > dial1 ; dial1++ ) {
			for ( dial2=0 ; dialTwo[0].length > dial2 ; dial2++ ) {
				for ( dial3=0 ; dialThree[0].length > dial3 ; dial3++ ) {
					for ( dial4=0 ; dialFour[0].length > dial4 ; dial4++ ) {
						if (dialFour[3][dial4] == 0 ) {
							for ( dial5=0 ; dialFive[0].length > dial5 ; dial5++ ) {
								ring1Val = addDial1( 0 , dial1 );
								ring2Val = addDial2( 1 , dial2 );
								ring3Val = addDial3( 2 , dial3 );
								ring4Val = addDial5( 3 , dial5 );
//								System.out.println( ring1Val +" + "+ ring2Val +" + "+ ring3Val +" + "+ ring4Val +" = "+ (ring1Val + ring2Val + ring3Val + ring4Val ) );
								if ( (ring1Val + ring2Val + ring3Val + ring4Val ) == 42 ) {
									checkOthers();
								}
							}
						} else {
							ring1Val = addDial1( 0 , dial1 );
							ring2Val = addDial2( 1 , dial2 );
							ring3Val = addDial3( 2 , dial3 );
							ring4Val = addDial4( 3 , dial4 );
//							System.out.println( ring1Val +" + "+ ring2Val +" + "+ ring3Val +" + "+ ring4Val +" = "+ (ring1Val + ring2Val + ring3Val + ring4Val ) );
							if ( (ring1Val + ring2Val + ring3Val + ring4Val ) == 42 ) {
								checkOthers();
							}
						}
							
//						System.out.println("==========    Rotate Dial Four");
					}
//					System.out.println("==========    Rotate Dial Three");
				}
//				System.out.println("==========    Rotate Dial Two");
			}
//			System.out.println("==========    Rotate Dial One");
		}
	}
	
	public int addDial1(int ringNum , int hour) {
		if (dialOne[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT] == 0 )
			return addDial2(ringNum , dial2);
		return dialOne[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT]; 
	}
	public int addDial2(int ringNum , int hour) {
		if (dialTwo[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT] == 0 )
			return addDial3(ringNum , dial3 );
		return dialTwo[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT]; 
	}
	public int addDial3(int ringNum , int hour) {
		if (dialThree[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT] == 0 )
			return addDial4(ringNum , dial4 );
		return dialThree[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT]; 
	}
	public int addDial4 (int ringNum , int hour ) {
		if (dialFour[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT] == 0 )
			return addDial5( ringNum , dial5 );
		return dialFour[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT];
	}
	public int addDial5 (int ringNum , int hour ) {
		return dialFive[ringNum][hour + BIG_SHIFT > 11 ? hour+BIG_SHIFT-12 : hour+BIG_SHIFT];
	}
	
	
	private void checkOthers() {
		for (int x=1 ; x < 12 ; x++ ) {
			int ring1Val, ring2Val, ring3Val, ring4Val = 0;
			BIG_SHIFT = x;
			
			ring1Val = addDial1(0 , dial1);
			ring2Val = addDial2(1 , dial2);
			ring3Val = addDial3(2 , dial3);
			ring4Val = addDial4(3 , dial4);
			
			System.out.println("--"+ ring1Val +" + "+ ring2Val +" + "+ ring3Val +" + "+ ring4Val +" = "+ (ring1Val + ring2Val + ring3Val + ring4Val ) );
			if (ring1Val + ring2Val + ring3Val + ring4Val != 42 ) break;
			
			if (x==10) 
				System.out.println("Could this be it?");
			
		}
		
		// reset BIG_SHIFT
		BIG_SHIFT = 0;
	}
}
