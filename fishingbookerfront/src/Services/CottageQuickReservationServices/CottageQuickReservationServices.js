const axios = require("axios");

const cottageQuickReservationServices = {
  getAllCottageQuickReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageQuickReservationsByOwner?cottageOwnerId=${ownerId}`
    );
  },

  getAllCottageReservationsByOwner: (ownerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageReservationsByOwner?cottageOwnerId=${ownerId}`
    );
  },

  getAllCottageReservationsByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageReservationsClient?clientId=${clientId}`
    );
  },

  getAllCottageQuickReservationByClient: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allQuickReservationsByClient?clientId=${clientId}`
    );
  },

  createCottageQuickReservationAction: (cottageAction) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageQuickReservations`,
      cottageAction
    );
  },

  createCottageReservation: (cottage) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageReservations`,
      cottage
    );
  },

  getFreeCottageQuickReservation: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}freeCottageQuickReservationsByCottage?cottageId=${cottageId}`
    );
  },

  getCottageQuickReservationByCottage: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}CottageQuickReservationsByCottage?cottageId=${cottageId}`
    );
  },


  ////ZA KALENDAR COTTAGERESERVATION

  getAllCottageReservationsByCottageOwner: (cottageOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageReservationCottageOwner?cottageOwnerId=${cottageOwnerId}`
    );
  },

  getAllCottageQuickReservationsByCottageOwner: (cottageOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageQuickReservationCottageOwner?cottageOwnerId=${cottageOwnerId}`
    );
  },
//client--------------------------------------------------------------------------------------
  getAllCottageQuickReservationByClientDateAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedCottageQuickReservationsByClientSortedByDateAsc?clientId=${clientId}`
    );
  },


  getAllCottageQuickReservationByClientDateDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedCottageQuickReservationsByClientSortedByDateDesc?clientId=${clientId}`
    );
  },


  getAllCottageQuickReservationByClientDurationAsc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedCottageQuickReservationsByClientSortedByDurationAsc?clientId=${clientId}`
    );
  },

  getAllCottageQuickReservationByClientDurationDesc: (clientId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}allFinishedCottageQuickReservationsByClientSortedByDurationDesc?clientId=${clientId}`
    );
  },
};

export default cottageQuickReservationServices;
