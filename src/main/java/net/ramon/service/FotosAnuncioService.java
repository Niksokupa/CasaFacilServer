/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ramon.service;

import javax.servlet.http.HttpServletRequest;
import net.ramon.bean.ReplyBean;

/**
 *
 * @author ramon
 */
public class FotosAnuncioService {
       HttpServletRequest oRequest;
	String ob = null;

	public FotosAnuncioService(HttpServletRequest oRequest) {
		super();
		this.oRequest = oRequest;
		ob = oRequest.getParameter("ob");
	}
        
        public ReplyBean create() throws Exception {

    }
}
