package com.andrew.MusicLibrary;

import org.springframework.stereotype.Service;

@Service("randomService")
public class RandomServiceImpl implements RandomService {

	public int doRandom() {
		return (int) Math.round( Math.random() * 1000 );
	}

}
