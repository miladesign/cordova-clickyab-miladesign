module.exports = {
	_opened: false,
	_closed: false,
	_received: false,
	_failed: false,

	//MilaDesign Start
	setUp: function() {
		var self = this;	
        cordova.exec(
            function (result) {
				if (typeof result == "string") {
					if (result == "onOpen") {
						self._opened = true;
						if (self.onOpen)
							self.onOpen();
					}
					else if (result == "onClose") {
						self._closed = true;
						if (self.onClose)
							self.onClose();
					}
					else if (result == "onReceive") {
						self._received = true;
						if (self.onReceive)
							self.onReceive();
					}
					else if (result == "onFailed") {
						self._failed = true;
						if (self.onFailed)
							self.onFailed();
					}
				}
				else {
					//var event = result["event"];
					//var location = result["message"];				
					//if (event == "onXXX") {
					//	if (self.onXXX)
					//		self.onXXX(location);
					//}
				}			
			}, 
			function (error) {
			},
            'Clickyab',
            'setUp',			
            []
        ); 
    },
    showFullAd: function(token) {
		var self = this;	
        cordova.exec(
            null,
            null,
            'Clickyab',
            'showFullAd',
            [token]
        ); 
    },
	OpenedFullAd: function() {
		return this._opened;
	},
	ClosedFullAd: function() {
		return this._closed;
	},
	ReceivedFullAd: function() {
		return this._received;
	},
	FailedFullAd: function() {
		return this._failed;
	},
	onOpen: null,
	onClose: null,
	onReceive: null,
	onFailed: null
	//MilaDesign End
};