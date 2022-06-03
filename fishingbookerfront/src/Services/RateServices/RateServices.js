const axios = require("axios");

const rateServices = {
  //FISHING CLASS AND INSTRUCTOR RATE
  getAllFishingClassRateRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassRateRequests`
    );
  },

  getAllInstructorRateRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorRateRequests`);
  },

  //COTTAGE AAND COTTAGEOWNER RATE
  getAllCottageRateRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottageRateRequests`);
  },

  getAllCottageOwnerRateRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageOwnerRateRequests`
    );
  },

  //BOAT AND BOATOWNER RATE
  getAllBoatRateRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatRateRequests`);
  },

  getAllBoatOwnerRateRequests: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boatOwnerRateRequests`);
  },

  //UPDATE FISHING CLASS AND INSTRUCTOR RATE
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

  //UPDATE COTTAGE AND COTTAGEOWNER RATE
  updateCottageRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottageRates/${rate.id}`,
      rate
    );
  },

  updateCottageOwnerRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottageOwnerRates/${rate.id}`,
      rate
    );
  },

  //UPDATE BOAT AND BOATOWNER RATE
  updateBoatRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatRates/${rate.id}`,
      rate
    );
  },

  updateBoatOwnerRate: (rate) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boatOwnerRates/${rate.id}`,
      rate
    );
  },

  getAvgRateByFishingClass: (fishingClassId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassAvgRate?fishingClassId=${fishingClassId}`
    );
  },

  getAvgRateByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageAvgRate?cottageId=${cottageId}`
    );
  },
};

export default rateServices;
