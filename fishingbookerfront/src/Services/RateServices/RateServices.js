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
};

export default rateServices;
