/*******************************************************************************
 * Copyright (c) 2010 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Denis Solonenko - initial API and implementation
 ******************************************************************************/
package com.handydev.financisto.report;

import static com.handydev.financisto.db.DatabaseHelper.V_REPORT_LOCATIONS;

import com.handydev.financisto.R;
import com.handydev.financisto.blotter.BlotterFilter;
import com.handydev.financisto.filter.WhereFilter;
import com.handydev.financisto.filter.Criteria;
import com.handydev.financisto.db.DatabaseAdapter;
import android.content.Context;
import com.handydev.financisto.model.Currency;

public class LocationsReport extends Report {

	public LocationsReport(Context context, Currency currency) {
		super(ReportType.BY_LOCATION, context, currency);
	}

	@Override
	public ReportData getReport(DatabaseAdapter db, WhereFilter filter) {
        cleanupFilter(filter);
		return queryReport(db, V_REPORT_LOCATIONS, filter);
	}

	@Override
	protected String alterName(long id, String name) {
		return id == 0 ? context.getString(R.string.no_fix) : name;
	}

	@Override
	public Criteria getCriteriaForId(DatabaseAdapter db, long id) {
		return Criteria.eq(BlotterFilter.LOCATION_ID, String.valueOf(id));
	}		
	
}
