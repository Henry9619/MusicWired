package com.icia.musicwired.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.musicwired.dao.CrawlingMapper;
import com.icia.musicwired.dto.MENUDTO;

import lombok.Setter;

@Service
public class CrawlingService {

	@Setter(onMethod_ = @Autowired)
	 private CrawlingMapper mapper;
	 
	
	 public void insert(String url) {
		 Document doc=null;
		 List<MENUDTO>list = new ArrayList<MENUDTO>();
		 
		 try {
			 doc=Jsoup.connect(url).get();
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 Elements elements = doc.select("div.systemPlaylistDetails");
		// Elements elements1 = doc.select("ul.systemPlaylistTrackList__list sc-clearfix sc-list-nostyle");
		
		 
		 Iterator<Element>element=elements.select("a.trackItem__trackTitle sc-link-dark sc-link-primary sc-font-light").iterator();
		// Iterator<Element>element1=elements1.select("ff").iterator();
		 while(element.hasNext()) {
			 MENUDTO menu= new MENUDTO();
			 String name=element.next().text();
			 
			 menu.setName(name);
			
			 list.add(menu);
			 System.out.println(list);
			System.out.println(menu);
		 }
		 mapper.insertName(list);
		 System.out.println(list);
	 }
	 
	 
}
