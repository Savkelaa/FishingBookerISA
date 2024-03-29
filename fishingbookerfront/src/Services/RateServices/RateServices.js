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

  createInstructorRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}instructorRates`,
      rate
    );
  },
  

  createCottageRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageRates`,
      rate
    );
  },

  createCottageOwnerRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageOwnerRates`,
      rate
    );
  },

  createBoatRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatRates`,
      rate
    );
  },

  createBoatOwnerRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatOwnerRates`,
      rate
    );
  },
  

  createFishingClassRate: (rate) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassRates`,
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

  getAvgRateByInstructor: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}instructorAvgRate?cottageId=${cottageId}`
    );
  },
  getAvgRateByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatAvgRate?boatId=${boatId}`
    );
  },
};

export default rateServices;
