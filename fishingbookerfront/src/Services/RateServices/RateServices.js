const axios = require("axios");

const rateServices = {
  getAllFishingClassRateRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassRateRequests`
    );
  },

  getAllInstructorRateRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorRateRequests`);
  },

  updateFishingClassRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}fishingClassRates/${rate.id}`,
      rate
    );
  },

  updateInstructorRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructorRates/${rate.id}`,
      rate
    );
  },
};

export default rateServices;
