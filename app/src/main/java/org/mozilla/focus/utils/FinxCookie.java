package org.mozilla.focus.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;

import java.util.ArrayList;

/**
 * Created by vladimir.popov on 8/24/2017.
 */


class DomainCookie {
    public String strDomain;
    public String strCookie;

    public DomainCookie(String strDomain) {
        this.strDomain = strDomain;
    }
};


public class FinxCookie {
    static final String FINDX_STORAGE_NAME = "org.mozilla.focus.utils.FinxCookie";

    ArrayList<DomainCookie> listDomains = new ArrayList<>();
    Context m_context = null;


    public FinxCookie(Context context) {
        m_context = context;
        listDomains.add(new DomainCookie("forum.findx.com"));
        listDomains.add(new DomainCookie("www.findx.al"));
        listDomains.add(new DomainCookie("www.findx.dk"));
        listDomains.add(new DomainCookie("www.findx.at"));
        listDomains.add(new DomainCookie("www.findx.ba"));
        listDomains.add(new DomainCookie("www.findx.be"));
        listDomains.add(new DomainCookie("www.findx.bg"));
        listDomains.add(new DomainCookie("www.findx.by"));
        listDomains.add(new DomainCookie("www.findx.ch"));
        listDomains.add(new DomainCookie("www.findx.cn"));
        listDomains.add(new DomainCookie("www.findx.co.il"));
        listDomains.add(new DomainCookie("www.findx.co.uk"));
        listDomains.add(new DomainCookie("www.findx.com"));
        listDomains.add(new DomainCookie("www.findx.com.ar"));
        listDomains.add(new DomainCookie("www.findx.com.br"));
        listDomains.add(new DomainCookie("www.findx.cz"));
        listDomains.add(new DomainCookie("www.findx.de"));
        listDomains.add(new DomainCookie("www.findx.ee"));
        listDomains.add(new DomainCookie("www.findx.es"));
        listDomains.add(new DomainCookie("www.findx.eu"));
        listDomains.add(new DomainCookie("www.findx.fi"));
        listDomains.add(new DomainCookie("www.findx.fo"));
        listDomains.add(new DomainCookie("www.findx.fr"));
        listDomains.add(new DomainCookie("www.findx.gl"));
        listDomains.add(new DomainCookie("www.findx.gr"));
        listDomains.add(new DomainCookie("www.findx.hk"));
        listDomains.add(new DomainCookie("www.findx.hr"));
        listDomains.add(new DomainCookie("www.findx.hu"));
        listDomains.add(new DomainCookie("www.findx.ie"));
        listDomains.add(new DomainCookie("www.findx.in"));
        listDomains.add(new DomainCookie("www.findx.info"));
        listDomains.add(new DomainCookie("www.findx.is"));
        listDomains.add(new DomainCookie("www.findx.jp"));
        listDomains.add(new DomainCookie("www.findx.kr"));
        listDomains.add(new DomainCookie("www.findx.li"));
        listDomains.add(new DomainCookie("www.findx.lt"));
        listDomains.add(new DomainCookie("www.findx.lu"));
        listDomains.add(new DomainCookie("www.findx.lv"));
        listDomains.add(new DomainCookie("www.findx.md"));
        listDomains.add(new DomainCookie("www.findx.mk"));
        listDomains.add(new DomainCookie("www.findx.mx"));
        listDomains.add(new DomainCookie("www.findx.my"));
        listDomains.add(new DomainCookie("www.findx.net"));
        listDomains.add(new DomainCookie("www.findx.net.in"));
        listDomains.add(new DomainCookie("www.findx.nl"));
        listDomains.add(new DomainCookie("www.findx.no"));
        listDomains.add(new DomainCookie("www.findx.nz"));
        listDomains.add(new DomainCookie("www.findx.org"));
        listDomains.add(new DomainCookie("www.findx.org.in"));
        listDomains.add(new DomainCookie("www.findx.ph"));
        listDomains.add(new DomainCookie("www.findx.pl"));
        listDomains.add(new DomainCookie("www.findx.pt"));
        listDomains.add(new DomainCookie("www.findx.ro"));
        listDomains.add(new DomainCookie("www.findx.rs"));
        listDomains.add(new DomainCookie("www.findx.ru"));
        listDomains.add(new DomainCookie("www.findx.se"));
        listDomains.add(new DomainCookie("www.findx.si"));
        listDomains.add(new DomainCookie("www.findx.sk"));
        listDomains.add(new DomainCookie("www.findx.tv"));
        listDomains.add(new DomainCookie("www.findx.tw"));
        listDomains.add(new DomainCookie("www.findx.uk"));
        listDomains.add(new DomainCookie("www.findx.us"));
        listDomains.add(new DomainCookie("www.findx.vn"));


        SharedPreferences sharedPref = m_context.getSharedPreferences(FINDX_STORAGE_NAME,  Context.MODE_PRIVATE);
        for(int i = 0; i < listDomains.size(); i++) {
            listDomains.get(i).strCookie = sharedPref.getString(listDomains.get(i).strDomain, null);
        }
    }


    public void Restore(CookieManager manager) {
        for(int i = 0; i < listDomains.size(); i++) {
            if(listDomains.get(i).strCookie != null) {
                manager.setCookie(listDomains.get(i).strDomain, listDomains.get(i).strCookie);
            }
        }
    }

    public void Save(CookieManager manager) {
        SharedPreferences sharedPref =  m_context.getSharedPreferences(FINDX_STORAGE_NAME,  Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        for(int i = 0; i < listDomains.size(); i++) {
            listDomains.get(i).strCookie = manager.getCookie(listDomains.get(i).strDomain);
            if(listDomains.get(i).strCookie != null) {
                editor.putString(listDomains.get(i).strDomain, listDomains.get(i).strCookie);
            }
        }
        editor.commit();
    }
}
