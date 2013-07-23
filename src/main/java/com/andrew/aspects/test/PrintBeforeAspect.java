package com.andrew.aspects.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintBeforeAspect {
	
	@Before("execution( * com.andrew.MusicLibrary.RandomService.doRandom(..))")
	public void printArgs() {
		System.out.println("Inside advice and Printing Args...");
	}
}
