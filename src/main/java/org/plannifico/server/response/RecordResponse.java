/*Copyright 2014 Rosario Alfano

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package org.plannifico.server.response;


import org.plannifico.data.fields.PlanningField;
import org.plannifico.data.records.MissingFieldException;
import org.plannifico.data.records.PlanningRecord;


public class RecordResponse implements Response {

	private PlanningRecord record;

	public RecordResponse (PlanningRecord record) {
		
		this.record = record;
	}
	
	public String getFields () {
		
		String response = "";
		
		for (PlanningField field : record.getFields()) {
			
			response = response += (field.getKey() + "=" +field.getValue()) + ";";
		}
		
		return response.substring(0,response.length()-1);
	}
	
	public String getMeasures () {
				
		String response = "";
		
		for (PlanningField field : record.getMeasures()) {
			
			response = response = response += (field.getKey() + "=" +field.getValue()) + ";";
		}
		
		return response.substring(0,response.length()-1);
	}
	
	public String getRecordKey () {
		
		try {
			
			return record.getRecordKey();
		
		} catch (MissingFieldException e) {
			
			return  "";
		}
	}
	
	@Override
	public Response append (Response response) {
		
		return null;
	}

	@Override
	public Response getContent() {
		
		return null;
	}

}