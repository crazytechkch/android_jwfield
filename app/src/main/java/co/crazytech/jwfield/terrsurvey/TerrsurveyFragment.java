package co.crazytech.jwfield.terrsurvey;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import co.crazytech.jwfield.R;

/**
 * Created by eric on 12/8/2015.
 */
public class TerrsurveyFragment extends Fragment {
    private View rootView;
    private WebView webView;

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView = inflater.inflate(R.layout.fragment_terrsurvey,container,false);
        }
        init();
        return rootView;
    }

    private void init() {
        webView = (WebView)rootView.findViewById(R.id.webView);
        webView.setWebViewClient(new TerservWebViewClient());
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        webView.loadUrl("http://mandrillapp.com/track/click/30578143/www.appsheet.com?p=eyJzIjoiSElCbGI5LWRkbUZ1bDUxbGNEaXBycWU1eDhVIiwidiI6MSwicCI6IntcInVcIjozMDU3ODE0MyxcInZcIjoxLFwidXJsXCI6XCJodHRwczpcXFwvXFxcL3d3dy5hcHBzaGVldC5jb21cXFwvc3RhcnRcXFwvN2I1YzlhN2ItYjJlMC00MDZkLThmOGMtZmJkNmZmMDk5N2Y5P3V0bV9tZWRpdW09ZW1haWwmdXRtX3NvdXJjZT10cmFuc2FjdGlvbmFsJnV0bV9jYW1wYWlnbj1ub3RpZnklNDBhcHBzaGVldC5jb21cIixcImlkXCI6XCI5MTA2ZWUxMmEwNTE0MjA5ODA0YTk5MzczMTdiZGM1M1wiLFwidXJsX2lkc1wiOltcIjYwNzFkOGJjNjRmODFlYTBhMzE4NGI2MDk2YjUzYzIyNThlY2Q1MDRcIl19In0");
    }

    public boolean canGoBack() {
        return webView.canGoBack();
    }

    public void goBack(){
        webView.goBack();
    }

    private class TerservWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
