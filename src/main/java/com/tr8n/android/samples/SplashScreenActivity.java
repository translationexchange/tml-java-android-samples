/*
 *  Copyright (c) 2014 Michael Berkovich, http://tr8nhub.com All rights reserved.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.tr8n.android.samples;

import android.content.Intent;
import android.os.Bundle;

import com.tr8n.android.activities.InitializationActivity;
import com.tr8n.core.Tr8n;
import com.tr8n.core.Utils;

public class SplashScreenActivity extends InitializationActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    public void onTr8nBeforeInit() {
        super.onTr8nBeforeInit();
    	
    	Tr8n.getConfig().setApplication(Utils.buildStringMap(
			"key", "3f7e22ee7fd92d55b",
			"secret", "560312081ccd2298d",
			"host", "https://sandbox.tr8nhub.com"
    	));

//    	Tr8n.getConfig().setApplication(Utils.buildStringMap(
//			"key", "e18f555faec314f9f",
//			"secret", "95ec4b72e1abc754e",
//			"host", "http://10.0.2.2:3000"
//    	));
        
    	Tr8n.getCache().reset();
    }
    
    @Override
    public void onTr8nAfterInit() {
    	Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
    	startActivity(intent);
    	finish();
    }

}

