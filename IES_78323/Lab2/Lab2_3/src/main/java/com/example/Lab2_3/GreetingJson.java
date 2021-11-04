/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Lab2_3;

/**
 *
 * @author Diogo
 */
public class GreetingJson {
        private final long id;
	private final String content;

	public GreetingJson(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
