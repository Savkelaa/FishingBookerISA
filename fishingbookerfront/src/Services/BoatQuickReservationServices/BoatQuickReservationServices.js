const axios = require("axios");

const boatQuickReservationServices = {
  getAllBoatQuickReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatQuickReservationsByOwner?boatOwnerId=${ownerId}`
    );
  },

  getAllBoatReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatReservationsByOwner?boatOwnerId=${ownerId}`
    );
  },

  getAllBoatReservationsByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatReservationsClient?clientId=${clientId}`
    );
  },

  createBoatQuickReservationAction: (boatAction) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatQuickReservations`,
      boatAction
    );
  },

  createBoatReservation: (boat) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatReservations`,
      boat
    );
  },

  getFreeBoatQuickReservation: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}freeBoatQuickReservationsByBoat?boatId=${boatId}`
    );
  },

  ////ZA KALENDAR BOATRESERVATION

  getAllBoatReservationsByBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatReservationBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },

  getAllBoatQuickReservationsByBoatOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatQuickReservationBoatOwner?boatOwnerId=${boatOwnerId}`
    );
  },

  getBoatQuickReservationByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}BoatQuickReservationsByBoat?boatId=${boatId}`
    );
  },

};

export default boatQuickReservationServices;
