import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class BoardMouseListener implements MouseListener {

	int x,y,moveToDo;
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 x=arg0.getX();
		 y=arg0.getY();
		 x/=Chess.sizeOfSquare;
		 y/=Chess.sizeOfSquare;
		

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		if (Chess.positions[y][x]!=null)
		{
		if ((arg0.getX()/Chess.sizeOfSquare)!=x || (arg0.getY()/Chess.sizeOfSquare)!= y)
		{
			if ((arg0.getX()/Chess.sizeOfSquare)>= 0 && (arg0.getX()/Chess.sizeOfSquare)< Chess.numberOfSquares && (arg0.getY()/Chess.sizeOfSquare) >= 0 &&((arg0.getY()/Chess.sizeOfSquare)< Chess.numberOfSquares))
			{
			
				if (Chess.positions[y][x].isWhite==Chess.whosTurnItIs)
				{
					if (Chess.positions[y][x].canMove(arg0.getX()/Chess.sizeOfSquare, arg0.getY()/Chess.sizeOfSquare))
					{
						int valueOfPiece=0;
						if (Chess.positions[arg0.getY()/Chess.sizeOfSquare][arg0.getX()/Chess.sizeOfSquare]!=null)
						{
							valueOfPiece=Chess.positions[arg0.getY()/Chess.sizeOfSquare][arg0.getX()/Chess.sizeOfSquare].valueOfPiece;
						}
						
						Piece temp = Chess.positions[y][x];
						
						Chess.positions[arg0.getY()/Chess.sizeOfSquare][arg0.getX()/Chess.sizeOfSquare] = temp;
						System.out.println(valueOfPiece);
						
						Chess.positions[y][x] = null;
						Chess.first.repaint();
						if(valueOfPiece==6)
						{
							//this is where I would exit if the king was taken
						}
						Chess.whosTurnItIs = !Chess.positions[arg0.getY()/Chess.sizeOfSquare][arg0.getX()/Chess.sizeOfSquare].isWhite;
						for (int y = 0 ;y<Chess.numberOfSquares;y++)
						{
							for (int i =0;i<Chess.numberOfSquares;i++)
							{
								if (Chess.positions[y][i]!=null)
								{
									if (Chess.positions[y][i].isWhite==false)
									{
										for (int j =0;j< Chess.numberOfSquares;j++)
										{
											for (int u =0; u<Chess.numberOfSquares;u++)
											{
												if (Chess.positions[y][i].canMove(u, j))
												{
													ArtificialInteligence temp1 = new ArtificialInteligence();
													if (Chess.positions[j][u]!=null)
													{
														temp1.pieceToMoveX=i;
														temp1.pieceToMoveY=y;
														temp1.possibleMoveX=u;
														temp1.possibleMoveY=j;
														temp1.valueOfPiece=Chess.positions[j][u].valueOfPiece;
														
														
													}else
													{
														temp1.pieceToMoveX=i;
														temp1.pieceToMoveY=y;
														temp1.possibleMoveX=u;
														temp1.possibleMoveY=j;
													}
													Chess.possibleMoves.add(temp1);
													temp1=null;
												}
											}
										}
									}
											
								}
							}
									
						}
						
						
						moveToDo = (int) (Math.random()*(Chess.possibleMoves.size()));
						
						Piece temp2 = Chess.positions[Chess.possibleMoves.get(moveToDo).pieceToMoveY][Chess.possibleMoves.get(moveToDo).pieceToMoveX];
						Chess.positions[Chess.possibleMoves.get(moveToDo).possibleMoveY][Chess.possibleMoves.get(moveToDo).possibleMoveX] = temp2;
		
						Chess.positions[Chess.possibleMoves.get(moveToDo).pieceToMoveY][Chess.possibleMoves.get(moveToDo).pieceToMoveX] = null;
						Chess.first.repaint();
						Chess.whosTurnItIs = !Chess.positions[Chess.possibleMoves.get(moveToDo).possibleMoveY][Chess.possibleMoves.get(moveToDo).possibleMoveX].isWhite;
						Chess.possibleMoves.clear();
					}
				}
			}
		}
		}// TODO Auto-generated method stub

	}

}