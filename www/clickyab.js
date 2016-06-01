module.exports = {

    init: function () {
        var self = this;
        cordova.exec(
            function (result) {
                console.log('setUp succeeded.' + result);

                if (typeof result == "string") {
                    //
                  /*  if (result == "AdClick") {
                        if (self.AdClick) {
                            self.AdClick();
                        }
                    }*/
                }
                else {
                    
                }
            },
            function (error) {
                console.log('setUp failed.');
            },
            'MdClickyab',
            'init',
            []
        );
    },
    showFullAd: function (token) {
        cordova.exec(
            null,
            null,
            'MdClickyab',
            'showFullAd',
            [token]
        );
    }
};