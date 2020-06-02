
function RemoveLastDirectoryPartOf(the_url){
    var the_arr = the_url.split('/');
    the_arr.pop();
    return( the_arr.join('/') );
}
function parseURLParams(url) {
	var queryStart = url.indexOf("?") + 1, queryEnd = url.indexOf("#") + 1
		|| url.length + 1, query = url.slice(queryStart, queryEnd - 1), pairs = query
		.replace(/\+/g, " ").split("&"), parms = {}, i, n, v, nv;

	if (query === url || query === "")
		return;

	for (i = 0; i < pairs.length; i++) {
		nv = pairs[i].split("=", 2);
		n = decodeURIComponent(nv[0]);
		v = decodeURIComponent(nv[1]);

		if (!parms.hasOwnProperty(n))
			parms[n] = [];
		parms[n].push(nv.length === 2 ? v : null);
	}
	return parms;
}

function toUpdate(game){
	
	var dateControl_start = document.querySelector('input[id="start"]').value;
	var dateControl_end = document.querySelector('input[id="end"]').value;
	
	var itemName = dateControl_start + '.' + dateControl_end;
	console.log(itemName);
	
	var newURL = RemoveLastDirectoryPartOf(window.location.href);
	
	var check = itemName.search("'");
	if(check != -1){
		var arr = itemName.split("'");
		window.location.href = newURL + '/admin_charts_area.jsp?name=' + arr[1];
	}
	else
		window.location.href = newURL + '/admin_charts_area.jsp?name=' + itemName;
}



async function getData(value) {
	if(value == null){
		async function getData_2() {	
			const url = '/CS308RegisterWithJPA/search/fromDB/oneMonthSummary/';
			const response = await
				fetch(url);
			const data_2 = await
				response.json();
			
			return data_2;
		}
		getData_2().then(response => {
		    json = JSON.stringify(response);
		    
		    var date = [];
			var trial = [];
		    
		    for(var i = 0; i < response.length; i++){
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

		const query = value.name[0];
		var array = query.split('.');
		
		start_date = array[0];
		end_date = array[1];
		console.log(start_date);
		console.log(end_date);
		
		document.querySelector('input[id="start"]').value = start_date;
		document.querySelector('input[id="end"]').value = end_date;
		
        var x = document.getElementsByClassName("example");
        x.innerHTML = "";
        x.innerHTML = "<canvas height=\"300px;\" width=\"auto;\" id=\"areachartfalse\"></canvas>";
        
        var canvas = document.querySelector('canvas');
        canvas.height = 300;
        async function getData_2() {    
            const url = '/CS308RegisterWithJPA/search/fromDB/drawChart/'+ start_date + '/' + end_date;
            const response = await
                fetch(url);
            const data_2 = await
                response.json();
            
            
            return data_2;
        }
        getData_2().then(response => {
            json = JSON.stringify(response);
            
            var date = [];
            var trial = [];
            
            for(var i = 0; i < response.length; i++){
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
	
	
}
var parsed = parseURLParams(window.location.href);
console.log(parsed);
getData(parsed);

$(document).ready(function() {
	$("#interval").click(function(){
		var dateControl_start = document.querySelector('input[id="start"]').value;
		var dateControl_end = document.querySelector('input[id="end"]').value;
		
		var startDate = new Date($('#start').val());
		var endDate = new Date($('#end').val());
		
		if (startDate < endDate){
			var parsed = parseURLParams(window.location.href);
			console.log(parsed);
			getData(parsed);
		}
		else{
			alert("End Date Must Be Bigger Than Start Date.")
		}
	});
	
});


