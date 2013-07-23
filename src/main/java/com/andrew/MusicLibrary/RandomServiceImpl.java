package com.andrew.MusicLibrary;

public class RandomServiceImpl implements RandomService {

	public int doRandom() {
		return (int) Math.round( Math.random() * 1000 );
	}

}
