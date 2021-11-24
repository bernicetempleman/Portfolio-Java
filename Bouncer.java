/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

/**
 *
 * @author Bernice
 */
public class Bouncer implements Runnable
{
	private final BouncingBall ball;

	public Bouncer( )
	{
		this.ball = new BouncingBall( );
	}

	public BouncingBall getBall( )
	{
		return this.ball;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run( )
	{
		this.ball.step( );
	}

}