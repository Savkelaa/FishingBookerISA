const axios = require("axios");

const rateService={

    getRateBoatById: (boatId) => {
        return axios.get(
          `${process.env.REACT_APP_API_URL}ratesByBoat/${boatId}`
        );
      },

};

export default rateService;