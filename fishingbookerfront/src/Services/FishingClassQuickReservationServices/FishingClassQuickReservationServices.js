const axios = require("axios");

const fishingClassQuickReservationServices = {
  createFishingClassQuickReservation: (fishingClassQuickReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassQuickReservations`,
      fishingClassQuickReservation
    );
  },

  getAllFishingClassReservationsByInstructor: (instructorId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationInstructor?instructorId=${instructorId}`
    );
  },

  getAllFishingClassReservationsByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingClassReservationsClient?clientId=${clientId}`
    );
  },

  createFishingClassReservation: (fishingClassReservation) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}fishingClassReservations`,
      fishingClassReservation
    );
  },
};

export default fishingClassQuickReservationServices;
