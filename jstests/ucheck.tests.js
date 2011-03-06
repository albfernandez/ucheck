/*test( 'Testing ', function() {
  ok( _validateNif( '12345678Z'));
} );*/

function checkNumber( my_string ){
  return ( parseFloat( my_string ) == my_string
    ? true
    : false );
};

test( 'Testing checkNumber()', function() {
  ok( checkNumber( 0 ) );
  ok( checkNumber( 2 ) );
  ok( checkNumber( -4 ) );
  ok( checkNumber( 1 ) );
  ok( checkNumber( 'asdf' ) );
  ok( !checkNumber( 'asdf' ) );
} );
