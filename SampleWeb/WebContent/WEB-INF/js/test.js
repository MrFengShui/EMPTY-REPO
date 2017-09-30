function submit_name() {
	var firstname = document.getElementById('firstname').value;
	var lastname = document.getElementById('lastname').value;
	console.log(firstname, lastname);
	var url = '/SampleWeb/test';
    var request = new XMLHttpRequest();
    request.open('POST', url);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send('firstname=' + firstname + '&lastname=' + lastname);
    request.addEventListener('load', function(event) {
    	var text = event.target.response + '</br>';
    	document.getElementById('result').innerHTML += text;
    });
}

function parse_json(json, space) {
	var text = json['text'];
	var type = json['type'];
	console.log(space + text);
	if (type == 'node') {
		space += '  ';
		var child = json['child'];
		child.forEach(function(item) {
			parse_json(item, space);
		});
	}
}

function print_json() {
	var json = [
		{
			"type": "node",
			"text": "Node 1",
			"child": [
				{
					"type": "leaf",
					"text": "Leaf 1-1"
				},
				{
					"type": "leaf",
					"text": "Leaf 1-2"
				},
				{
					"type": "leaf",
					"text": "Leaf 1-3"
				}
			]
		},
		{
			"type": "node",
			"text": "Node 2",
			"child": [
				{
					"type": "node",
					"text": "Node 2-1",
					"child": [
						{
							"type": "leaf",
							"text": "Leaf 2-1-1"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-1-2"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-1-3"
						}
					]
				},
				{
					"type": "node",
					"text": "Node 2-2",
					"child": [
						{
							"type": "leaf",
							"text": "Leaf 2-2-1"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-2-2"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-2-3"
						}
					]
				},
				{
					"type": "node",
					"text": "Node 2-3",
					"child": [
						{
							"type": "leaf",
							"text": "Leaf 2-3-1"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-3-2"
						},
						{
							"type": "leaf",
							"text": "Leaf 2-3-3"
						}
					]
				}
			]
		},
		{
			"type": "node",
			"text": "Node 3",
			"child": [
				{
					"type": "node",
					"text": "Node 3-1",
					"child": [
						{
							"type": "leaf",
							"text": "Leaf 3-1-1"
						},
						{
							"type": "leaf",
							"text": "Leaf 3-1-2"
						},
						{
							"type": "leaf",
							"text": "Leaf 3-1-3"
						}
					]
				},
				{
					"type": "leaf",
					"text": "Leaf 3-2"
				},
				{
					"type": "leaf",
					"text": "Leaf 3-3"
				},
				{
					"type": "leaf",
					"text": "Leaf 3-4"
				}
			]
		}
	];
	json.forEach(function(item) {
		parse_json(item, '');
	});
}