$(document).ready(function() {
	$("#interval").click(function(){
		var dateControl_start = document.querySelector('input[id="start"]').value;
		var dateControl_end = document.querySelector('input[id="end"]').value;
		
		var startDate = new Date($('#start').val());
		var endDate = new Date($('#end').val());
		
		if (startDate < endDate){
			var x = document.getElementsByClassName("example");
			x.innerHTML = "";
			x.innerHTML = "<canvas height=\"300px;\" width=\"auto;\" id=\"areachartfalse\"></canvas>";
			
			var canvas = document.querySelector('canvas');
			canvas.height = 300;
			async function getData_2() {	
				const url = '/CS308RegisterWithJPA/search/fromDB/drawChart/'+ dateControl_start + '/' + dateControl_end;
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
			getData_2().then(response => {
			    json = JSON.stringify(response);
			    
			    var date = [];
				var total_money = [];
				var trial = [];
				
			    
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
		}
		else{
			alert("End Date Must Be Bigger Than Start Date.")
		}
		
		
		
		
		
	});
	async function getData() {	
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
	getData().then(response => {
	    json = JSON.stringify(response);
	    
	    var date = [];
		var total_money = [];
		var trial = [];
	    
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


