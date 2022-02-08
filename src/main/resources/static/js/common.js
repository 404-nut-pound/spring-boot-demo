/**
 * 
 */

let contextPath = `/${location.pathname.split('/')[1]}`;

function resetUndefined(input) {
	return input === null || input === undefined ? '' : input;
}

async function fetchText(url, method, header, body) {
	if(resetUndefined(url) === '' || resetUndefined(method) === '') {
		console.log('URL 혹은 Method가 빈 값입니다.');
		
		return;
	}
	
	let fetchParam = {
		method: method
	}
	
	if(resetUndefined(header) !== '' || header instanceof Object) {
		fetchParam.headers = header;
	}
	if(resetUndefined(body) !== '' || body instanceof Object) {
		fetchParam.body = JSON.stringify(body);
	}
	
	return await fetch(url, fetchParam)
	.then(response => response.ok ? response.text() : '');
}

async function fetchJson(url, method, header, body) {
	if(resetUndefined(url) === '' || resetUndefined(method) === '') {
		console.log('URL 혹은 Method가 빈 값입니다.');
		
		return;
	}
	
	let fetchParam = {
		method: method
	}
	
	if(resetUndefined(header) !== '' || header instanceof Object) {
		fetchParam.headers = header;
	}
	if(resetUndefined(body) !== '' || body instanceof Object) {
		fetchParam.body = JSON.stringify(body);
	}
	
	return await fetch(url, fetchParam)
	.then(response => response.ok ? response.json() : {});
}