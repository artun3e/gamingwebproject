$(document).ready(function() {

	var date = [];
	var total_money = [];
	var trial = [];
	
	async function getData(trial) {	
		const url = '/CS308RegisterWithJPA/search/fromDB/oneMonthSummary/';
		const response = await
			fetch(url);
		const data_2 = await
			response.json();
		
		//var string_data = JSON.stringify(data_2);
		//console.log(string_data);
		//var parsed = JSON.parse(string_data);
		//console.log(parsed);
		//console.log(typeof data_2);
		//console.log(parsed.length);
		
		
		return data_2;
		//parsed.forEach(element => parsed.push(element));
		//for(var k in parsed) {
		//	date.push(k);
		//	total_money.push(parsed[k]);
		//}
	}
	getData(trial).then(response => {
	    json = JSON.stringify(response);
	    
	    for(var i = 0; i < response.length; i++){
			//console.log(data_2[i].profit);
			
			trial.push(response[i].profit);
			date.push(response[i].date.substring(5, 10));
		}
	    
	    console.log(trial)
	    console.log(trial[2])
	    
	    /*----------------------------------------*/
		/*  1.  Area Chart
		/*----------------------------------------*/
		var ctx = document.getElementById("areachartfalse");
		var areachartfalse = new Chart(ctx, {
			type: 'line',
			data: {
				labels: date,
				datasets: [{
					label: "Total Margin on That Day",
					fill: false,
	                backgroundColor: '#00c292',
					borderColor: '#00c292',
					data: trial
	            }]
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				spanGaps: false,
				title:{
					display:true,
					text:'Daily Margin Chart'
				},
				elements: {
					line: {
						tension: 0.000001
					}
				},
				plugins: {
					filler: {
						propagate: false
					}
				},
				scales: {
					xAxes: [{
						ticks: {
							autoSkip: false,
							maxRotation: 0
						}
					}]
				}
			}
		});
	});
});


