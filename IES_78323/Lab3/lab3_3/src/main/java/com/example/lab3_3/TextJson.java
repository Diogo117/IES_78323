/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.lab3_3;

/**
 *
 * @author Diogo
 */
public class TextJson {
        private final long id;
	private final String quote;
        private final String title;

	public TextJson(long id, String title, String quote) {
		this.id = id;
                this.title = title;
		this.quote = quote;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
        
        public String getQuote() {
		return quote;
	}
}
