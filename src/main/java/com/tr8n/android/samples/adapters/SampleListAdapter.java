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

package com.tr8n.android.samples.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tr8n.android.samples.R;
import com.tr8n.android.samples.models.Sample;
import com.tr8n.core.Tr8n;

public class SampleListAdapter extends BaseAdapter {
	
	private Context context;
	private List<Sample> samples;
	
	public SampleListAdapter(Context context, List<Sample> samples){
		this.context = context;
		this.samples = samples;
	}

	public int getCount() {
		return samples.size();
	}

	public Object getItem(int position) {		
		return samples.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.sample_list_item, null);
        }
         
		convertView.setMinimumHeight(180);
		Sample sample = samples.get(position);
		
        TextView txtTitle = (TextView) convertView.findViewById(R.id.textview_result_title);
        txtTitle.setText(Tr8n.translate("Result:"));
        txtTitle = (TextView) convertView.findViewById(R.id.textview_result);
        txtTitle.setText(sample.getTranslation());
        
        txtTitle = (TextView) convertView.findViewById(R.id.textview_tml_title);
        txtTitle.setText(Tr8n.translate("TML:"));
        txtTitle = (TextView) convertView.findViewById(R.id.textview_tml);
        txtTitle.setText(sample.getLabel());
        
        txtTitle = (TextView) convertView.findViewById(R.id.textview_tokens_title);
        txtTitle.setText(Tr8n.translate("Tokens:"));
        txtTitle = (TextView) convertView.findViewById(R.id.textview_tokens);
        txtTitle.setText(sample.getTokensJSON());

        return convertView;
	}

}
